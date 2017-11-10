package androidcndd.bkdn.cvn.a311;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Camera_chip extends AppCompatActivity {
    private static final int REQUEST_OPEN_FOLDER = 1 ;
    private static final int REQUEST_OPEN_CAMERA = 2;
    private static final int REQUEST_OPEN_GALLERY = 3 ;
    ImageButton btnFolder, btnGallery, btnCamera;
    Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_chip);
        //btnFolder = (ImageButton) findViewById(R.id.btnFolder);
        btnCamera = (ImageButton) findViewById(R.id.btnCamera);
        btnGallery = (ImageButton) findViewById(R.id.btnGallery);


       /* btnFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             openFolder();
            }
        });*/
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    private void openGallery() {
        Intent pickPhotoIntent = new Intent();
        pickPhotoIntent.setAction(Intent.ACTION_GET_CONTENT);
        pickPhotoIntent.setType("image/*");
        startActivityForResult(pickPhotoIntent , REQUEST_OPEN_GALLERY);
    }

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent,REQUEST_OPEN_CAMERA);
    }

     private void openFolder() {
        Intent openPhotoIntent = new Intent();
        openPhotoIntent.setAction(Intent.ACTION_GET_CONTENT);
        openPhotoIntent.setType("*/*");
        startActivityForResult(openPhotoIntent,REQUEST_OPEN_FOLDER);
    }
}
