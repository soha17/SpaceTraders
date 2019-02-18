package edu.gatech.cs2340.milestones.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Difficulty;

import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.ConfigurationViewModel;

public class ConfigurationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ConfigurationViewModel viewModel;

    private Player player = new Player();
    private boolean editing;

    private EditText nameField;
    private Spinner diffSpinner;
    //private Spinner testSpinner;
    private TextView pilotPoint;
    private TextView enginnerPoint;
    private TextView tradePoint;
    private TextView fighterPoint;
    private TextView skillPoint;

    private Button p_plusb;
    private Button p_minusb;
    private Button e_plusb;
    private Button e_minusb;
    private Button t_plusb;
    private Button t_minusb;
    private Button f_plusb;
    private Button f_minusb;

    private int ppoint = player.getPilotPoint();

    private int skillpoint = 16;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Log.d("here", "you got here_configact");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(false);
        }

        nameField = findViewById(R.id.name_input);
        diffSpinner = findViewById(R.id.difficuly_spinner);
        pilotPoint = findViewById(R.id.p_count);
        enginnerPoint = findViewById(R.id.e_count);
        tradePoint = findViewById(R.id.t_count);
        fighterPoint = findViewById(R.id.f_count);
        skillPoint = findViewById(R.id.s_count);

        player = new Player("put your name");
        Log.d("here", player.getName());
        nameField.setText(player.getName());

        skillPoint.setText(""+player.getSkillPoint());
        pilotPoint.setText(""+player.getPilotPoint());
        enginnerPoint.setText(""+player.getEngineerPoint());
        tradePoint.setText(""+player.getTradePoint());
        fighterPoint.setText(""+player.getFighterPoint());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.difficulty1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diffSpinner.setAdapter(adapter);
        diffSpinner.setOnItemSelectedListener(this);

        //Buttons


            p_plusb = findViewById(R.id.p_plus);
            p_plusb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ppoint = ppoint + 1;
                    skillpoint--;
                    pilotPoint.setText(String.valueOf(ppoint));
                    skillPoint.setText(String.valueOf(skillpoint));
                }
            });
            p_minusb = findViewById(R.id.p_plus);
            p_minusb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                ppoint = ppoint + 1;
                skillpoint--;
                pilotPoint.setText(String.valueOf(ppoint));
                skillPoint.setText(String.valueOf(skillpoint));
                }
            });


        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
    }

    public void onNextPressed(View view) {
        if (player.getSkillPoint() == 0) {
            player.setName(nameField.getText().toString());
            player.setPilotPoint(Integer.parseInt(pilotPoint.getText().toString()));
            player.setEngineerPoint(Integer.parseInt(enginnerPoint.getText().toString()));
            player.setTradePoint(Integer.parseInt(tradePoint.getText().toString()));
            player.setFighterPoint(Integer.parseInt(fighterPoint.getText().toString()));

            //viewModel.addPlayer(player);
            Log.d("user data:", player.toString());
        }

        finish();
    }
    public void onSkillButton(View view) {
        int id = view.getId();
        //
        if (id == R.id.p_plus) {
            if(player.getSkillPoint() > 0) {
                int p1 = player.getPilotPoint() + 1;
                player.setPilotPoint(p1);
                int s1 = player.getSkillPoint() - 1;
                player.setSkillPoint(s1);
                pilotPoint.setText("" + player.getPilotPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.e_plus) {
            if(player.getSkillPoint() > 0) {
                int e1 = player.getEngineerPoint() + 1;
                player.setEngineerPoint(e1);
                int s2 = player.getSkillPoint() - 1;
                player.setSkillPoint(s2);
                enginnerPoint.setText("" + player.getEngineerPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.t_plus) {
            if(player.getSkillPoint() > 0) {
                int t1 = player.getTradePoint() + 1;
                player.setTradePoint(t1);
                int s3 = player.getSkillPoint() - 1;
                player.setSkillPoint(s3);
                tradePoint.setText("" + player.getTradePoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.f_plus) {
            if(player.getSkillPoint() > 0) {
                int f1 = player.getFighterPoint() + 1;
                player.setFighterPoint(f1);
                int s4 = player.getSkillPoint() - 1;
                player.setSkillPoint(s4);
                fighterPoint.setText("" + player.getFighterPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        //minus
        if (id == R.id.p_minus) {
            if (player.getPilotPoint() > 1) {
                int p2 = player.getPilotPoint() - 1;
                player.setPilotPoint(p2);
                int s5 = player.getSkillPoint() + 1;
                player.setSkillPoint(s5);
                pilotPoint.setText("" + player.getPilotPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.e_minus) {
            if(player.getEngineerPoint() > 1) {
                int e2 = player.getEngineerPoint() - 1;
                player.setEngineerPoint(e2);
                int s6 = player.getSkillPoint() + 1;
                player.setSkillPoint(s6);
                enginnerPoint.setText("" + player.getEngineerPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.t_minus) {
            if(player.getTradePoint() > 1) {
                int t2 = player.getTradePoint() - 1;
                player.setTradePoint(t2);
                int s7 = player.getSkillPoint() + 1;
                player.setSkillPoint(s7);
                tradePoint.setText("" + player.getTradePoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.f_minus) {
            if(player.getFighterPoint() > 1) {
                int f2 = player.getFighterPoint() - 1;
                player.setFighterPoint(f2);
                int s8 = player.getSkillPoint() + 1;
                player.setSkillPoint(s8);
                fighterPoint.setText("" + player.getFighterPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
