
public class LoginTest {
	
	public static void main(String [] arg) {
		System.out.println("1123");
		

		String s = "efgh";
		int result = 0;
        char[] chars = s.toCharArray();
        // char[] target = new char[chars.length];
        int start_char = 'a';
        int end_char = 'z';
        int current_char;
        int next_char;
        for(int i =0 ; i< chars.length ;i++){
            
            current_char = (int) chars[i];
            if(i+1 <chars.length ){
                next_char = (int) chars[i+1]; 
             }else{
                 break;
             }
            if(current_char == next_char){
                int nChar = next_char+1;
                if(nChar >end_char){
                    chars[i+1] =(char) start_char;
                }else{
                    chars[i+1] =(char) nChar;
                }
                result++;
            }else if(current_char+1 == next_char ){
                int nChar = next_char+1;
                if(nChar >end_char){
                    chars[i+1] =(char) start_char;
                }else{
                    chars[i+1] =(char) nChar;
                }
                result++;
            }
        }
        
        System.out.println(result);
		
	}
}
