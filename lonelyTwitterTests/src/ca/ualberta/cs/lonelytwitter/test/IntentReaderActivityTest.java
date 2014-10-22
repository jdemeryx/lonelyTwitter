package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

//TODO: Add your code here:
    public void testSendText() {
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing send");
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	assertEquals(ira.getText(), "testing send");
    }
    
    public void testDisplayText() {
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing display text");
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	TextView textView = 
    			(TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
    	assertEquals(textView.getText(), "testing display text");
    }
    
    public void testDoubleText() {
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing double text");
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	
    	assertEquals(ira.getText(), "testing double texttesting double text");
    }
    
    public void testReverseText() {
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing reverse text");
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();

    	assertEquals(ira.getText(), "txet esrever gnitset");
    }
    
    public void testDefaultMessage() {
    	Intent intent = new Intent();
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	
    	assertEquals(ira.getText(), "Default Text");
    }
    
    public void testTextView() {
    	Intent intent = new Intent();
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	TextView test = (TextView)ira.findViewById(
    			ca.ualberta.cs.lonelytwitter.R.id.intentText);
    	TextView test2 = (TextView)ira.getWindow().getDecorView().findViewById(
    			ca.ualberta.cs.lonelytwitter.R.id.intentText);
    	ViewAsserts.assertOnScreen(test, test2);
    }
}
