package QrCode;
import java.util.ArrayList;


public class Polynomial 
{
	 ArrayList<Integer> P = new ArrayList<Integer>();
	 ArrayList<Integer> C = new ArrayList<Integer>();
	 int Degree;
	 public Polynomial()	 
	 {
	 }
	 
	 public Polynomial(ArrayList<Integer> poly, int Degree)	 
	 {
		 this.C=poly;
		 this.Degree=Degree;
		 for(int i=Degree;i>=0;i--)
		 {
			 P.add(i);
		 }
	 }
	 public Polynomial(int[] poly, int Degree)	 
	 {
		 for(int i=0;i<=Degree;i++)
		 {
			 this.C.add(poly[i]);
		 }
		
		 this.Degree=Degree;
		 for(int i=Degree;i>=0;i--)
		 {
			 P.add(i);
		 }
	 }
	 
}
