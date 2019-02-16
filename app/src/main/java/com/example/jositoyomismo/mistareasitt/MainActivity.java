package com.example.jositoyomismo.mistareasitt;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jositoyomismo.mistareasitt.db.controladorBaseDatos;

public class MainActivity extends AppCompatActivity {


    controladorBaseDatos controladorDB;

    private ArrayAdapter <String> adaptador;

    ListView listViewTareas;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        controladorDB = new controladorBaseDatos(this);

        listViewTareas = (ListView)findViewById(R.id.listaTareas);

        actualizarInterfaz();

    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        //AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        // TO-DO

        final EditText cajaDeTexto = new EditText(this);

        AlertDialog dialogo = new AlertDialog.Builder(this)

                .setTitle("Tarea NUEVA")

                .setMessage("¿Qué desea hacer a continuación?")

                .setView(cajaDeTexto)

                .setPositiveButton("Añadir", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {

                        String tarea = cajaDeTexto.getText().toString();

                        controladorDB.anadeTarea(tarea);

                        actualizarInterfaz();

                    }
                })

                .setNegativeButton("Cancelar", null)

                .create();

        dialogo.show();

        return super.onOptionsItemSelected(item);
    }

    private void actualizarInterfaz() {

        if (controladorDB.numRegistros() == 0) {

            listViewTareas.setAdapter(null);

        } else {

            adaptador = new ArrayAdapter <>(this, R.layout.item_tarea, R.id.tareaTitulo, controladorDB.agarraTareas());

            listViewTareas.setAdapter(adaptador);

        }
    }
    public void borrarTarea(View view){

        View parent = (View) view.getParent();

        TextView tareaTextView = (TextView) parent.findViewById(R.id.tareaTitulo);

        String tareas = tareaTextView.getText().toString();

        controladorDB.borrarTarea(tareas);

        actualizarInterfaz();

    }
}
