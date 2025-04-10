
package com.example.onlinevoting; 
 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.RadioButton; 
import android.widget.RadioGroup; 
import android.widget.Toast; 
 
import androidx.appcompat.app.AppCompatActivity; 
 
public class VoteActivity extends AppCompatActivity { 
 
    private RadioGroup rgCandidates; 
    private Button btnSubmitVote; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_vote); 
 
        rgCandidates = findViewById(R.id.rg_candidates); 
        btnSubmitVote = findViewById(R.id.btn_submit_vote); 
 
        btnSubmitVote.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                int selectedId = rgCandidates.getCheckedRadioButtonId(); 
 
                if (selectedId == -1) { 
                    Toast.makeText(VoteActivity.this, "Please select a candidate!", 
Toast.LENGTH_SHORT).show(); 
                } else { 
                    RadioButton selectedCandidate = findViewById(selectedId); 
                    String vote = selectedCandidate.getText().toString(); 
 
                    // Navigate to ResultActivity and pass the selected vote 
                    Intent intent = new Intent(VoteActivity.this, ResultActivity.class); 
                    intent.putExtra("VOTE", vote); 
                    startActivity(intent); 
                    finish(); 
                } 
            } 
        }); 