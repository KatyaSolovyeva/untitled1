import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String f=sc.nextLine();
        String login="";
        String password="";
        String confirmPassword="";
        int l=0;
        int k=0;

        char fArr[]=f.toCharArray();
        for(int x=0; x<f.length()-2;x++){
            while(fArr[x]!=' '){
                login+=fArr[x];
                l=x;
                x++;
            }
            break;
        }
        for(int x=l+2; x<f.length()-2;x++){
            while(fArr[x]!=' '){
                password+=fArr[x];
                k=x;
                x++;
            }
            break;
        }
        for(int x=k+2; x<f.length();x++) {
            while (fArr[x] != fArr[f.length() - 1]) {
                confirmPassword += fArr[x];
                x++;
            }
            confirmPassword += fArr[f.length() - 1];

            break;
        }

        try {
            boolean n;
            n=login(login, password, confirmPassword);
            if(n==true) System.out.println("true");
        }
        catch(WrongLoginException fnf) {
            System.err.println("This is WrongLoginException");
        } catch(WrongPasswordException e) {
            System.err.println("This is WrongPasswordException");
        }
        System.out.println(login);
        System.out.println(password);
        System.out.println(confirmPassword);
    }


    public static boolean login(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException  {
        boolean k=true;
        boolean n=true;
        boolean m=true;
        if(login.length()>19){
            throw new WrongLoginException();
        }else{
            char xArr[]=login.toCharArray();
            for(int x=0; x<login.length();x++){
                if(xArr[x]!='_' && (xArr[x]<'0' ||xArr[x]>'9') && (xArr[x]<'a'||xArr[x]>'z') &&(xArr[x]<'A'||xArr[x]>'Z')){
                    n=false;
                    throw new WrongLoginException();
                }
            }
        }
        if(!password.equals(confirmPassword)){
            throw new WrongPasswordException();
        }

        if(password.length()>19){
            throw new WrongPasswordException();
        }else{
            char x1Arr[]=password.toCharArray();
            for(int x=0; x<password.length();x++){
                if(x1Arr[x]!='_' && (x1Arr[x]<'0' ||x1Arr[x]>'9') && (x1Arr[x]<'a'||x1Arr[x]>'z') &&(x1Arr[x]<'A'||x1Arr[x]>'Z')){
                    n=false;
                    throw new WrongPasswordException();
                }
            }
        }
        if(m==true && k==true && n==true){ return true;}else {
            return false;}

    }
}


class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        super();
    }
    public WrongPasswordException(String message) {
        super(message);
    }
}

class WrongLoginException extends Exception{
    public WrongLoginException() {
        super();
    }
    public WrongLoginException(String message) {
        super(message);
    }
}
