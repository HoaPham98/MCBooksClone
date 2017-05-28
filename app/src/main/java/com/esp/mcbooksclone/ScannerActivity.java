package com.esp.mcbooksclone;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler, ScannerListener {

    private static final int RC_HANDLE_CAMERA_PERM = 2;
    private ZXingScannerView mScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_scan);
        setSupportActionBar(toolbar);

        InitView();

        if(ContextCompat.checkSelfPermission(this,"android.permission.CAMERA") != 0){
            requestCameraPermission();
        }


        mScanner = (ZXingScannerView) findViewById(R.id.scanner_view);
        //setContentView(mScanner);
        mScanner.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScanner.startCamera();          // Start camera on resume
    }

    @Override
    public void onResume() {
        super.onResume();
        //mScanner.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScanner.startCamera();          // Start camera on resume
    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(getBaseContext(),result.getText(),Toast.LENGTH_SHORT).show();

        showDialogBookNotFound();
    }

    private void requestCameraPermission() {
        //Log.w("TAG", "Camera permission is not granted. Requesting permission");
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, RC_HANDLE_CAMERA_PERM);
    }

    @Override
    public void reseumCamera() {
        this.mScanner.resumeCameraPreview(this);
    }

    public void showDialogBookNotFound() {
        NotFoundDialog mFragment = new NotFoundDialog();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("not_found_TAG");
        if(prev != null){
            ft.remove(prev);
        }

        mFragment.show(getFragmentManager(),"not_found_TAG");

    }

    public void InitView(){
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
