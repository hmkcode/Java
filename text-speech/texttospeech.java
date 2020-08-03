import com.sun.speech.freetts.*;
import java.io.* ;
public class texttospeech
{
private String speaktext;
public void dospeak(String speak,String voice)
{
speaktext=speak; 
try
{
VoiceManager voiceManager=VoiceManager.getInstance();
Voice voices=voiceManager.getVoice(voice);
Voice voices1[]=voiceManager.getVoices();
System.out.println("Available Voices");
for(int i=0;i<voices1.length;i++)
System.out.println(voices1[i].getName());
Voice sp=null;
if(voices!=null)
{
sp=voices; 
}
else
{
System.out.println("No Voice Available");
}
sp.allocate();
sp.speak(speaktext);
sp.deallocate();
}
catch(Exception e)
{
e.printStackTrace();
}
} 
public static void main(String[] args)
{
String name=null;
//int value=0;
tts obj=new tts();
InputStreamReader istream=new InputStreamReader(System.in) ;
BufferedReader bufRead=new BufferedReader(istream) ;
try 
{
while(!("stop").equals(name))
{
//char c=(char)value;
name=bufRead.readLine();
//if(c==' ')
obj.dospeak(name,"kevin16");
//name=""+c;
}
}
catch(IOException err) 
{
System.out.println("Error reading line");
}
}
}