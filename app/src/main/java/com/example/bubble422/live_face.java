package com.example.bubble422;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.huawei.hms.mlsdk.MLAnalyzerFactory;
import com.huawei.hms.mlsdk.common.LensEngine;
import com.huawei.hms.mlsdk.common.MLAnalyzer;
import com.huawei.hms.mlsdk.face.MLFace;
import com.huawei.hms.mlsdk.face.MLFaceAnalyzer;
import com.huawei.hms.mlsdk.face.MLFaceAnalyzerSetting;
import com.huawei.hms.mlsdk.face.MLFaceEmotion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.huawei.hms.feature.dynamic.b.v;


public class live_face extends AppCompatActivity {/*
    final int SMILE=0;
    final int ANGRY=1;
    final int DISGUST=6;
    final int FEAR=3;
    final int SAD=4;
    final int SURPRISE=5;
    private final static int STOP_PREVIEW = 7;
    private LensEnginePreview mPreview;
    private final static int TAKE_PHOTO = 8;
    private LensEngine mLensEngine;
    private static final int CAMERA_PERMISSION_CODE = 2;
    private int lensType = LensEngine.FRONT_LENS;
    private String storePath = "/storage/emulated/0/DCIM/Camera";


    private MLFaceAnalyzer analyzer;
    private void createFaceAnalyzer() {
        MLFaceAnalyzerSetting setting =
                new MLFaceAnalyzerSetting.Factory()
                        .setFeatureType(MLFaceAnalyzerSetting.TYPE_FEATURES)
                        .setKeyPointType(MLFaceAnalyzerSetting.TYPE_UNSUPPORT_KEYPOINTS)
                        .setMinFaceProportion(0.1f)
                        .setTracingAllowed(true)
                        .create();
        this.analyzer = MLAnalyzerFactory.getInstance().getFaceAnalyzer(setting);
        this.analyzer.setTransactor(new MLAnalyzer.MLTransactor<MLFace>() {
            @Override
            public void destroy() {
            }

            @Override
            public void transactResult(MLAnalyzer.Result<MLFace> result) {
                SparseArray<MLFace> faceSparseArray = result.getAnalyseList();
                for (int i = 0; i < faceSparseArray.size(); i++) {
                    MLFaceEmotion emotion = faceSparseArray.valueAt(i).getEmotions();
                    float smilingPossibility=0.85f;
                    if (emotion.getSmilingProbability() > smilingPossibility) {
                        mHandler.sendEmptyMessage(SMILE);
                    }
                    if (emotion.getAngryProbability() > 0.85f) {
                        mHandler.sendEmptyMessage(ANGRY);
                    }
                    if (emotion.getDisgustProbability() > 0.85f) {
                        mHandler.sendEmptyMessage(DISGUST);
                    }
                    if (emotion.getFearProbability() > 0.85f) {
                        mHandler.sendEmptyMessage(FEAR);
                    }
                    if (emotion.getSadProbability() > 0.85f) {
                        mHandler.sendEmptyMessage(SAD);
                    }
                    if (emotion.getSurpriseProbability() > 0.85f) {
                        mHandler.sendEmptyMessage(SURPRISE);
                    }
                }
            }
        });}

    private void requestCameraPermission() {
        final String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this, permissions, live_face.CAMERA_PERMISSION_CODE);
            return;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != live_face.CAMERA_PERMISSION_CODE) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }
        if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            this.createLensEngine();
            return;
        }
    }
    private void createLensEngine() {
        Context context = this.getApplicationContext();
        // Create LensEngine
        this.mLensEngine = new LensEngine.Creator(context, this.analyzer).setLensType(this.lensType)
                .applyDisplayDimension(640, 480)
                .applyFps(25.0f)
                .enableAutomaticFocus(true)
                .create();}
    private void takePhoto() {
        this.mLensEngine.photograph(null,
                new LensEngine.PhotographListener() {
                    @Override                public void takenPhotograph(byte[] bytes) {
                        mHandler.sendEmptyMessage(STOP_PREVIEW);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        saveBitmapToDisk(bitmap);
                    }
                });}
    private String saveBitmapToDisk(Bitmap bitmap) {
        File appDir = new File(storePath);
        if (!appDir.exists()) {
            boolean res = appDir.mkdir();
            if (!res) {
                Log.e(TAG, "saveBitmapToDisk failed");
                return "";
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_face_analyse);
        if (savedInstanceState != null) {
            this.lensType = savedInstanceState.getInt("lensType");
        }
        this.mPreview = this.findViewById(R.id.preview);
        this.createFaceAnalyzer();
        //this.findViewById(R.id.facingSwitch).setOnClickListener(this);
        // Checking Camera Permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            this.createLensEngine();
        } else {
            this.requestCameraPermission();
        }
    }
        final Handler mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case SMILE:
                        Toast.makeText(live_face.this, "Smile", Toast.LENGTH_SHORT).show();
                        break;
                    case ANGRY:
                        Toast.makeText(live_face.this, "angry", Toast.LENGTH_SHORT).show();
                        break;
                    case DISGUST:
                        Toast.makeText(live_face.this, "disgust", Toast.LENGTH_SHORT).show();
                        break;
                    case FEAR:
                        Toast.makeText(live_face.this, "fear", Toast.LENGTH_SHORT).show();
                        break;
                    case SAD:
                        Toast.makeText(live_face.this, "sad", Toast.LENGTH_SHORT).show();
                        break;
                    case SURPRISE:
                        Toast.makeText(live_face.this, "surprise", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        };*/
    private static final String TAG = "LiveFaceAnalyse";

    private static final int CAMERA_PERMISSION_CODE = 2;

    private MLFaceAnalyzer analyzer;

    private LensEngine mLensEngine;

    private LensEnginePreview mPreview;

    private int lensType = LensEngine.FRONT_LENS;

    private boolean isFront = true;

    private final float smilingRate = 0.8f;

    private final float smilingPossibility = 0.85f;

    private final static int STOP_PREVIEW = 1;

    private final static int SMILE = 2;

    private final static int ANGRY = 3;

    private final static int DISGUST = 4;

    private final static int FEAR = 5;

    private final static int SAD = 6;

    private final static int SURPRISE = 7;

    private boolean safeToTakePicture = false;

    private String storePath = "/storage/emulated/0/DCIM/Camera";

    private Button restart,readytakephoto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_live_face_analyse);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (savedInstanceState != null) {
            this.lensType = savedInstanceState.getInt("lensType");
        }
        this.mPreview = this.findViewById(R.id.preview);
        this.createFaceAnalyzer();
        this.findViewById(R.id.facingSwitch);
        this.restart = findViewById(R.id.restart);
        this.readytakephoto=findViewById(R.id.facingSwitch);

        readytakephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessage(STOP_PREVIEW);
            }
        });


        // Checking Camera Permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            this.createLensEngine();
        } else {
            this.requestCameraPermission();
        }
    }

    private void requestCameraPermission() {
        final String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this, permissions, live_face.CAMERA_PERMISSION_CODE);
            return;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.startLensEngine();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.mPreview.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.mLensEngine != null) {
            this.mLensEngine.release();
        }
        if (this.analyzer != null) {
            try {
                this.analyzer.stop();
            } catch (IOException e) {
                Log.e(live_face.TAG, "Stop failed: " + e.getMessage());
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != live_face.CAMERA_PERMISSION_CODE) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }
        if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            this.createLensEngine();
            return;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("lensType", this.lensType);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onClick(View v) {
        this.isFront = !this.isFront;
        if (this.isFront) {
            this.lensType = LensEngine.FRONT_LENS;
        } else {
            this.lensType = LensEngine.BACK_LENS;
        }
        if (this.mLensEngine != null) {
            this.mLensEngine.close();
        }
        this.createLensEngine();
        this.startLensEngine();
    }

    private Handler mHandler = new Handler() {
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent i1=new Intent();
            switch (msg.what) {
                case STOP_PREVIEW:
                    stopPreview();
                    break;
                case SMILE:
                    i1.putExtra("emotion","Smile");
                    setResult(100,i1);
                    live_face.this.finish();
                    break;
                case ANGRY:
                    i1.putExtra("emotion","Angry");
                    setResult(100,i1);
                    live_face.this.finish();
                    break;
                case DISGUST:
                    i1.putExtra("emotion","Disgust");
                    setResult(100,i1);
                    live_face.this.finish();
                    break;
                case FEAR:
                    i1.putExtra("emotion","Fear");
                    setResult(100,i1);

                    live_face.this.finish();
                    break;
                case SAD:
                    i1.putExtra("emotion","Sad");
                    setResult(100,i1);

                    live_face.this.finish();
                    break;
                case SURPRISE:
                    i1.putExtra("emotion","Smile");
                    setResult(100,i1);
                    live_face.this.finish();
                    break;
                default:
                    break;
            }
        }
    };

    private void createFaceAnalyzer() {
        // Create a face analyzer. You can create an analyzer using the provided customized face detection parameter
        // MLFaceAnalyzerSetting
        MLFaceAnalyzerSetting setting =
                new MLFaceAnalyzerSetting.Factory()
                        .setFeatureType(MLFaceAnalyzerSetting.TYPE_FEATURES)
                        .setKeyPointType(MLFaceAnalyzerSetting.TYPE_UNSUPPORT_KEYPOINTS)
                        .setMinFaceProportion(0.1f)
                        .setTracingAllowed(true)
                        .create();
        this.analyzer = MLAnalyzerFactory.getInstance().getFaceAnalyzer(setting);
        this.analyzer.setTransactor(new MLAnalyzer.MLTransactor<MLFace>() {
            @Override
            public void destroy() {
            }

            @Override
            public void transactResult(MLAnalyzer.Result<MLFace> result) {
                SparseArray<MLFace> faceSparseArray = result.getAnalyseList();
                for (int i = 0; i < faceSparseArray.size(); i++) {
                    MLFaceEmotion emotion = faceSparseArray.valueAt(i).getEmotions();
                    if (emotion.getSmilingProbability() > 0.8f) {
//                        try {
//                            live_face.this.wait(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        mHandler.sendEmptyMessage(SMILE);
                    }
                    if (emotion.getAngryProbability() > 0.85f) {
                        mHandler.sendEmptyMessage(ANGRY);
                    }
                    if (emotion.getDisgustProbability() > 0.85f) {
                        mHandler.sendEmptyMessage(DISGUST);
                    }
                    if (emotion.getFearProbability() > 0.85f) {
                        mHandler.sendEmptyMessage(FEAR);
                    }
                    if (emotion.getSadProbability() > 0.85f) {
                        mHandler.sendEmptyMessage(SAD);
                    }
                    if (emotion.getSurpriseProbability() > 0.85f) {
                        mHandler.sendEmptyMessage(SURPRISE);
                    }
                }
            }
        });
    }

    private void createLensEngine() {
        Context context = this.getApplicationContext();
        // Create LensEngine
        this.mLensEngine = new LensEngine.Creator(context, this.analyzer).setLensType(this.lensType)
                .applyDisplayDimension(640, 480)
                .applyFps(25.0f)
                .enableAutomaticFocus(true)
                .create();
    }

    private void startLensEngine() {
        this.restart.setVisibility(View.GONE);
        if (this.mLensEngine != null) {
            try {
                this.mPreview.start(this.mLensEngine);
                this.safeToTakePicture = true;
            } catch (IOException e) {
                Log.e(live_face.TAG, "Failed to start lens engine.", e);
                this.mLensEngine.release();
                this.mLensEngine = null;
            }
        }
    }

    private void takePhoto() {
        this.mLensEngine.photograph(null,
                new LensEngine.PhotographListener() {
                    @Override
                    public void takenPhotograph(byte[] bytes) {
                        mHandler.sendEmptyMessage(STOP_PREVIEW);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        saveBitmapToDisk(bitmap);
                    }
                });
    }


    public void startPreview(View view) {
        createFaceAnalyzer();
        mPreview.release();
        createLensEngine();
        startLensEngine();
    }

    private void stopPreview() {
        this.restart.setVisibility(View.VISIBLE);
        if (mLensEngine != null) {
            mLensEngine.release();
            this.safeToTakePicture = false;
        }
        if (analyzer != null) {
            try {
                this.analyzer.stop();
            } catch (IOException e) {
                Log.e(live_face.TAG, "Stop failed: " + e.getMessage());
            }
        }
    }

    private String saveBitmapToDisk(Bitmap bitmap) {
        File appDir = new File(storePath);
        if (!appDir.exists()) {
            boolean res = appDir.mkdir();
            if (!res) {
                Log.e(TAG, "saveBitmapToDisk failed");
                return "";
            }
        }

        String fileName = "SmileDemo" + System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //通过io流的方式来压缩保存图片
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();

            //保存图片后发送广播通知更新数据库
            Uri uri = Uri.fromFile(file);
            this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }


}