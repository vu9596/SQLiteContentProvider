package vunt.com.vn.sqlitecontentprovider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemSelectedListener {
    public static final String STRING_TEL = "tel:";
    private ListContactFragment mListContactFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListContactFragment = new ListContactFragment();
        getFragmentManager().beginTransaction().add(R.id.container, mListContactFragment).commit();
    }

    @Override
    public void onPhoneImageSelected(String phoneNumber) {
        callWithPhoneNumber(phoneNumber);
    }

    private void callWithPhoneNumber(String phoneNumber) {
        String uri = appendString(STRING_TEL, phoneNumber);
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(uri));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            finish();
        }
        startActivity(intent);
    }

    public static String appendString(String... param) {
        StringBuilder result = new StringBuilder();
        for (String s : param) {
            result.append(s);
        }
        return result.toString();
    }
}
