package QrCode;

import QrCodeConstants.ErrorCorrectionTable;
import QrCodeConstants.GaloisField256;
import QrCodeConstants.GeneratorPolynomials;


public class ErrorCorrection {
	int _Version;
	int _Error_Correction_Level;
	Polynomial B;
	int NumberErrorCorrection;
	ErrorCorrectionTable ErrorCorrectionTable;
	int IndexStart;
	
	public ErrorCorrection()
	{
		
	}
	public ErrorCorrection(int _Version,int _Error_Correction_Level)
	{
		this.ErrorCorrectionTable=new QrCodeConstants.ErrorCorrectionTable() ;
		this._Version=_Version;
		this._Error_Correction_Level=_Error_Correction_Level;
		NumberErrorCorrection=GetNumErrorCorrection();
		this.B=GeneratePolynomial();
		
	}
	public Polynomial GeneratePolynomial()
	{
		return new Polynomial(GeneratorPolynomials.get(NumberErrorCorrection),NumberErrorCorrection);
	}
	public int GetNumErrorCorrection()
	{
		return this.ErrorCorrectionTable.GetECCodewordsPerBlock(this._Version, this._Error_Correction_Level);
	}
	
	public Polynomial Divide(Polynomial A)
	{
			int PAi0=A.P.get(0);
			for(int i=0;i<A.P.size();i++)
			{
				A.P.set(i, A.P.get(i) + NumberErrorCorrection);				
			}

			for(int i=0;i<B.P.size();i++)
			{
				B.P.set(i, B.P.get(i) + PAi0);				
			}
			
			Polynomial T=new Polynomial();
			int Cci,n=A.C.size()-1,j,PB0,Asize;
			PB0=B.P.get(0);
			while(n>=0)
			 {
				 Cci=GaloisField256.toExp((A.C.get(0)));
				 if(Cci!=-1)
				 {
					 for(j=0;j<B.C.size();j++)
					 {						 
						 T.C.add(GaloisField256.toInt(((Cci+B.C.get(j))%255)));
						 T.P.add(PB0-j);
					 }
					 for(j=0;j<T.C.size();j++)
					 {
						 Asize=A.C.size();
						 if(j>=Asize)
						 {
							 A.C.add(j,0 ^ T.C.get(j));
							 A.P.add(T.P.get(j));
						 }
						 else
						 {
							 A.C.set(j,A.C.get(j) ^ T.C.get(j));
						 }
					 }
				 }
				 T=new Polynomial();
				 A.C.remove(0);
				 A.P.remove(0);
				 n--;
				 PB0--;
			 }
			 return A;
	}
}
