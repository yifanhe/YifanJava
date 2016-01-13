package MathematicsObjects;

public class Term{
	/**
	 * 
	 */
	double coefficient;
	String variable;
	int exponent;
	boolean constant;//this is true if a Term has no variable expression
	//TODO: Write getters for all of the above fields
	public double getCoefficient() {
		return coefficient;
	}

	public String getVariable() {
		return variable;
	}

	public int getExponent() {
		return exponent;
	}

	public boolean isConstant() {
		return constant;
	}
	
	public Term(double coefficient, String var, int exp){
		//set the value of all the fields
		//if variable is non-empty, sets constant to 'false'
		this.coefficient = coefficient;
		variable = var;
		if(!var.equals("")) //if the variable doesn't exist
		{
			constant = false;
		}
		else
		{
			constant = true;
			exp=0; //0 degree equation
		}
		exponent = exp;
		if(coefficient ==0){
			variable = "";
			exponent =0;
		}
	}

	/**
	 *a constructor for constant: 
	 */
	Term(double constant){
		//sets coefficient to constant, variable to "", exponent to "0" and constant to 'true')
		coefficient = constant;
		variable = "";
		exponent = 0;
		this.constant = true;
	}
	/**
	 *Write getters for each field
	 *Note that the getter for the boolean should be called 'isConstant'
	 */ 

	public Term getAddInverse(){
		//returns the additive inverse of this Term
		return new Term(coefficient*-1,variable,exponent); //inverse of 5 is -5
	}

	public int getDegree(){
		//returns the exponent
		return exponent;
	}

	public boolean isPositive(){
		//returns true if the coefficient is positive (or zero), false otherwise
		if(coefficient >= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}	
	/**

	* NEW STUFF FOR 4.1

	* */

	/**

	* 

	* 

	* @param s

	* @param t

	* @return 'true' if s and t are like terms (same variable and exponent)

	*/
	public static boolean areLikeTerms(Term s, Term t){
        if(s.getDegree()==t.getDegree() && s.variable == t.variable){
        	return true;
        }
        return false;
	}
	/**

	* returns a new Term with same variable and exponent as s and t but combined coefficient

	* @param s

	* @param t

	* @return

	*/
	public static Term combine(Term s, Term t){
      return new Term ((s.coefficient + t.coefficient), s.variable, s.exponent);
	}



	public void setCoefficient(double d) {
		this.coefficient = d;
		
	}
	public String toString(){
		/**
		 *Some tips to consider:
		 *doubles always print with trailing zeros (i.e. 2.0) This is not desireable
		 *If a term has a coefficient of 1 or -1, the 1 should not be shown. 
		 *If a term has an exponent of 1, the 1 should not be shown
		 *For exponents, use '^'. The GUI will change it into superscript.
		 */
		String coeString = (int)coefficient+"";
		String varString = variable;
		String expString = "";
		if (exponent != 0) expString = "^"+exponent;
		if(coeString.equals("1")){
			coeString = "";
		}
		if(coeString.equals("-1")){
			coeString = "-";
		}
		if(expString.equals("^1")){
			expString = "";
		}
		
		return coeString+varString+expString;
		
		/*String s = "";
		if(!constant && (coefficient ==-1.0 || coefficient ==1.0)){
			if(coefficient ==-1.0) s+="-";
		}
		else{
			s+= coefficient;
		}
		s+=*/
	}

}
