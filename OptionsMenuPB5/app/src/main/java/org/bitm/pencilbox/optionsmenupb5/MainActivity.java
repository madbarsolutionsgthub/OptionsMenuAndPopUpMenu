package org.bitm.pencilbox.optionsmenupb5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean isLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        //Toast.makeText(this, "onCreateOptionsMenu", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem loginItem = menu.findItem(R.id.login);
        MenuItem logoutItem = menu.findItem(R.id.logout);
        if(isLoggedIn){
            loginItem.setVisible(false);
            logoutItem.setVisible(true);
        }else{
            loginItem.setVisible(true);
            logoutItem.setVisible(false);
        }
        //Toast.makeText(this, "onPrepareOptionsMenu", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.login:
                //Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
                isLoggedIn = true;
                break;
            case R.id.logout:
                //Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
                isLoggedIn = false;
                break;
            case R.id.home:
                //Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this,view);
        getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        popupMenu.show();

    }
}
