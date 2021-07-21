package com.pd.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout line1;
    ListView lv;
    ArrayAdapter adapter;
    ArrayList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        line1 = (LinearLayout) findViewById( R.id.line1 );

        lv = (ListView) findViewById( R.id.Listview );
        list = new ArrayList();
        list.add( "Mars" );
        list.add( "Mercury" );
        list.add( "Venus" );
        list.add( "Earth" );
        list.add( "Jupiter" );
        list.add( "Saturn" );
        list.add( "Neptune" );
        list.add( "Pluto" );

        adapter = new ArrayAdapter( this, android.R.layout.simple_list_item_1, list );
        lv.setAdapter( adapter );
        registerForContextMenu( lv );
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu( menu, v, menuInfo );
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate( R.menu.contextmenu, menu );
        menu.setHeaderTitle( "select any action" );
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.p1) {
            line1.setBackgroundColor( Color.RED );
            Toast.makeText( getApplicationContext(), "Home is selected", Toast.LENGTH_SHORT ).show();
        } else if (item.getItemId() == R.id.p2) {
            line1.setBackgroundColor( Color.YELLOW );
            Toast.makeText( getApplicationContext(), "Profile is selected", Toast.LENGTH_SHORT ).show();
        } else if (item.getItemId() == R.id.p3) {
            line1.setBackgroundColor( Color.CYAN );
            Toast.makeText( getApplicationContext(), "Settings is selected", Toast.LENGTH_SHORT ).show();
        } else {
            line1.setBackgroundColor( Color.BLUE );
            return false;
        }
        return true;
    }
}