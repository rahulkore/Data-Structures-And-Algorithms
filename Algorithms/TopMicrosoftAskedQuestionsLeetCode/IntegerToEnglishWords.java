package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
/**Convert a non-negative integer num to its English words representation.

 

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven" */
public class IntegerToEnglishWords {

    String[] bigUnits = {"", " Thousand", " Million", " Billion"};
    String[] digits = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
    String[] tens = {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
    String[] tenToTwenty = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
    
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        StringBuilder result = new StringBuilder();
        int bigUnitIndex = 0;
        while(num!=0){
            if(num % 1000 !=0 ){
            System.out.println(num%1000);
            result.insert(0, parseThreeDigits(num % 1000) + bigUnits[bigUnitIndex] + "");
            System.out.println(result);
            }
            num /= 1000;
            bigUnitIndex++;
        }
        
        return result.toString().trim();
    }
    
    private String parseThreeDigits(int num){
        StringBuilder result = new StringBuilder();
        if(num > 99){
            result.append(digits[num / 100] + " Hundred");
            num = num % 100;
        }
        if(num > 19){
            result.append(tens[num/10]);
            num = num % 10;
        }
        if(num > 9){
            result.append(tenToTwenty[num%10]);
            return result.toString();
        }
        
        return result.append(digits[num]).toString();
    }
    public static void main(String[] args) {
        
    }
    
}
