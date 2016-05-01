package com.example.andre.videoclubclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by andre on 4/28/2016.
 */
public class DisplayContact extends AppCompatActivity {
    private DBHelper mydb;

    TextView name;
    TextView phone;
    TextView homephone;
    TextView address;
    TextView email;
    int idUpdate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);
        name = (TextView) findViewById(R.id.editTextName);
        phone = (TextView) findViewById(R.id.editTextPhone);
        homephone = (TextView) findViewById(R.id.editTextHomephone);
        address = (TextView) findViewById(R.id.editTextAddress);
        email = (TextView) findViewById(R.id.editTextEmail);

        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");
            if (Value > 0) {
                // esta es la vista no agregar contacto
                Cursor rs = mydb.getData(Value);
                idUpdate = Value;
                rs.moveToFirst();

                String name1 = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_NAME));
                String phone1 = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_PHONE));
                String homephone1 = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_HOMEPHONE));
                String address1 = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_ADDRESS));
                String email1 = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_EMAIL));

                if (!rs.isClosed()) {
                    rs.close();
                }
                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.INVISIBLE);

                name.setText((CharSequence) name1);
                name.setFocusable(false);
                name.setClickable(false);

                phone.setText((CharSequence) phone1);
                phone.setFocusable(false);
                phone.setClickable(false);

                homephone.setText((CharSequence) homephone1);
                homephone.setFocusable(false);
                homephone.setClickable(false);

                address.setText((CharSequence) address1);
                address.setFocusable(false);
                address.setClickable(false);

                email.setText((CharSequence) email1);
                email.setFocusable(false);
                email.setClickable(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate menu - agrega items al bar si esta presente
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            int Value = extras.getInt("id");
            if (Value > 0) {
                getMenuInflater().inflate(R.menu.display_contact, menu);
            } else {
                getMenuInflater().inflate(R.menu.main_menu, menu);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.Edit_Contact:
                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.VISIBLE);
                name.setEnabled(true);
                name.setFocusableInTouchMode(true);
                name.setClickable(true);

                phone.setEnabled(true);
                phone.setFocusableInTouchMode(true);
                phone.setClickable(true);

                homephone.setEnabled(true);
                homephone.setFocusableInTouchMode(true);
                homephone.setClickable(true);

                address.setEnabled(true);
                address.setFocusableInTouchMode(true);
                address.setClickable(true);

                email.setEnabled(true);
                email.setFocusableInTouchMode(true);
                email.setClickable(true);

                return true;
            case R.id.Delete_Contact:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deleteContact)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mydb.deleteContact(idUpdate);
                                Toast.makeText(getApplicationContext(), "El contacto ha sido borrado", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // cancelado por el usuario
                    }
                });
                AlertDialog d = builder.create();
                d.setTitle("Borrar contacto");
                d.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void run(View view) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");
            if (Value > 0) {
                if (mydb.updateContact(idUpdate, name.getText().toString(), phone.getText().toString(),
                        homephone.getText().toString(), address.getText().toString(), email.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Se ha editado un contacto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "No se pudo editar el contacto", Toast.LENGTH_SHORT).show();
                }
            } else {
                if(mydb.insertContact(name.getText().toString(), phone.getText().toString(), homephone.getText().toString(),
                        address.getText().toString(), email.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Se ha agregado un contacto", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No se pudo agregar el contacto", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
