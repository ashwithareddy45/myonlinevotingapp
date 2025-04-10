package com.example.onlinevoting; 
 
import android.os.Bundle; 
import android.widget.TextView; 
import androidx.appcompat.app.AppCompatActivity; 
import java.util.HashMap; 
 
public class ResultActivity extends AppCompatActivity { 
 
    private TextView tvVoteResults; 
    private static HashMap<String, Integer> voteCounts = new HashMap<>(); 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_result); 
 
        // Initialize the TextView 
        tvVoteResults = findViewById(R.id.tv_vote_results); 
 
        // Get the vote data from the intent 
        String vote = getIntent().getStringExtra("VOTE"); 
        if (vote != null) { 
            // Update the vote count 
            int currentCount = voteCounts.getOrDefault(vote, 0); 
            voteCounts.put(vote, currentCount + 1); 
        } 
 
        // Display the results 
        displayVoteResults(); 
    } 
 
    private void displayVoteResults() { 
        StringBuilder results = new StringBuilder("Vote Results:\n\n"); 
 
        for (String option : voteCounts.keySet()) { 
            int count = voteCounts.getOrDefault(option, 0); 
            results.append(option).append(": ").append(count).append(" votes\n"); 
        } 
 
        tvVoteResults.setText(results.toString()); 
    } 
}