package com.sample;



import javax.swing.JOptionPane;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class BoardgameChooser {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Question {

        public String question;
        public String answer;
        public String[] options;
        

        public Question(String q, String[] o) {
        	this.question = q;
        	this.options = o;
        	this.answer = null;
        }

        public void showQuestion(){


        	int n = JOptionPane.showOptionDialog(null,
        	    question,
        	    "Answer me",
        	    JOptionPane.DEFAULT_OPTION,
        	    JOptionPane.QUESTION_MESSAGE,
        	    null,
        	    options,
        	    options[0]);

        	answer = options[n];
            
        }
       
    }
    
    public static class Choice {
    	public String choice;
    	
    	public Choice(String c) {
    		this.choice = c;
    		JOptionPane.showMessageDialog(null, c);
    	}
    }

    

}
