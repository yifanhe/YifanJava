package MathematicsObjects;

import java.util.ArrayList;

public class Equation{

	private ArrayList<Term> leftSide;
	private ArrayList<Term> rightSide;
	private boolean cancelRight;
	private ArrayList<Double> solution;
	//TODO: Make getters for all of the above
	public ArrayList<Term> getLeftSide() {
		return leftSide;
	}

	public void setLeftSide(ArrayList<Term> leftSide) {
		this.leftSide = leftSide;
	}

	public ArrayList<Term> getRightSide() {
		return rightSide;
	}

	public void setRightSide(ArrayList<Term> rightSide) {
		this.rightSide = rightSide;
	}

	public boolean isCancelRight() {
		return cancelRight;
	}

	public void setCancelRight(boolean cancelRight) {
		this.cancelRight = cancelRight;
	}

	public ArrayList<Double> getSolution() {
		return solution;
	}

	public void setSolution(ArrayList<Double> solution) {
		this.solution = solution;
	}


	public Equation(ArrayList<Term> leftSide, ArrayList<Term> rightSide){
		//sets values of leftSide and rightSide only
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}

	public boolean isLinear(){
		//returns 'true' if this equation is linear
		//and every term is either constant or has the same variable
		return isOfDegree(1);
	}
	private boolean isOfDegree(int degree){
		int maxDegree = 0;
		int minDegree =0;
		String variable ="";
		for(Term t: leftSide){
			if(t.getDegree()>maxDegree)maxDegree = t.getDegree();
			if(t.getDegree()<minDegree) return false;
			if(!t.isConstant()) variable = t.getVariable();
		}
		for(Term t:rightSide){
			if(t.getDegree()>maxDegree)maxDegree = t.getDegree();
			if(t.getDegree()<minDegree) return false;
			if(!t.isConstant()) variable = t.getVariable();
		}
		if(maxDegree == degree && variablesMatch(variable)) return true;
		else return false;
	}
	private boolean variablesMatch(String s){
		for(Term t: leftSide){
			if(!t.isConstant() && !t.getVariable().equals(s)) return false;
		}
		for(Term t: rightSide){
			if(!t.isConstant() && !t.getVariable().equals(s)) return false;
		}
		return true;
	}
	public boolean isQuadratic(){
		//returns 'true' if this equation is quadratic
		//and every term is either constant or has the same variable
		return isOfDegree(2);
	}

	public boolean isSolveable(){
		//returns 'true' if this equation is linear or quadratic, 'false' otherwise 
		//(because in this project we are not programming a means of solving anything other than linear and quadratic equations)
		if(isLinear() || isQuadratic()){
			return true;
		}
		return false;
	}

	public boolean cancelRight(){
		//sets the value of cancelRight and
		//returns 'true' if the equation should be solved by subtracting terms from the right side, false if it is better to subtract terms on the left side
		Term highestLeft = getHighestDegreeTerm(leftSide);
		Term highestRight = getHighestDegreeTerm(rightSide);
		if(highestRight.getDegree()>highestLeft.getDegree() && highestRight.isPositive()){
			return false;
		}
		if(highestRight.getDegree()<highestLeft.getDegree() && !highestRight.isPositive()){
			return true;
		}
		if(highestLeft.getDegree()>highestRight.getDegree() && highestLeft.isPositive()){
			return true;
		}
		if(highestRight.getDegree()==highestLeft.getDegree() && highestRight.getCoefficient()>highestRight.getCoefficient()){
			return true;
		}
		else return false;
	}

	public String toString(){
		/**
		 *Take your time on this method!
		 *There are many things to consider:
		 *Every terms should be separated by a '+' UNLESS it has a negative coefficient. 
		 *When a term is negative, the negative sign will appear as a minus.
		 */
		String returnString = getSideString(leftSide) +  " = " + getSideString(rightSide);
		return returnString;
	}

	private String getSideString(ArrayList<Term> side){
		String s = "";
		try{
			s=side.get(0).toString();
		}
		catch(Exception e){
			s="0";
		}
		for(int i=1; i<side.size();i++){
			if(side.get(i).isPositive()) s+= "+"+side.get(i);
			else s+= "-" +side.get(i).toString().replaceFirst("-", "");
		}
		return s;
	}
	public static Term getHighestDegreeTerm(ArrayList<Term> side){
		//returns the term in the ArrayList that is the highest degree.
		//example
		//3x^2 + 4x^3 - 12x + x^2
		//will return 4x^3 
		int high = -1;
		Term highTerm = null;
		for(Term x: side){
			if(x.getDegree()>high){
				high = x.getDegree();
				highTerm = x;
			}
		}
		return highTerm;
	}
	/**
	 * NEW STUFF FOR 4.1
	 * adds the additiveInverse of everything on the sideBeingCancelled
	 * to both sides of the Equation
	 * @param sideBeingCanceled
	 */

	public void toZeroOnOneSide(ArrayList<Term> sideBeingCanceled){
	 int s = sideBeingCanceled.size();
		for(int i =0; i<s;i++)
		{
			Term t = sideBeingCanceled.get(i);
			leftSide.add(t.getAddInverse());
			rightSide.add(t.getAddInverse());
		}
		simplify(rightSide);
		simplify(leftSide);
	}

	/**
	 * @param side - simplifies the specified side of the equation
	 * Notes: This method should check every Term on the specified side of the equation 
	 * with every other Term to check if they are like terms (use Term.areLikeTerms(Term s, Term t)
	 * If they are, it should reassign the current Term to the combined result (use Term.combine(Term s, Term t)
	 * and remove the one with which it combined.
	 * Finally, if the resulting term has a coefficient of zero should be removed.
	 * For example, Suppose side contains 5x + 3 -5x. Call the three terms a, b and c, respectively
	 * 1. It checks to see if 5x and 3 (a and b) are like terms, they are not
	 * 2. It checks to see if 5x and -5x (a and c) are like terms, they are
	 * 3. Since 5x and -5x are like terms, a = Term.cobine(a, c) then leftSide.remove(c)
	 * 4. Now side contains 0x + 3. Since term a has a coefficient of zero, remove it.
	 * 5. Now side contains 3. 
	 * ONE MORE NOTE: Since you will be removing items from side, use a standard for loop
	 * and remember that when something is moved, everything "slides over"
	 */

	public void simplify(ArrayList<Term> side){
		for(Term t: side){
			for(Term s: side){
				if(t!=s){
					if(Term.areLikeTerms(s,t)){
						Term result=Term.combine(s, t);
						t.setCoefficient(result.coefficient);
						s.setCoefficient(0);
					}
				}
			}
		}
		for(int i=0; i<side.size();i++){
			Term t= side.get(i);
			if((int)t.getCoefficient()==0){
				side.remove(i);
			}
		}
	}


	/**
	 * @param sideWithVariable - we can assume the side with a variable is of the form ax + b
	 * @return the solution
	 * Example: 3x + 21 = 0
	 * 1. Identify the constant term in the sideWithVariable (21)
	 * 2. Identify the variable term in the sideWithVariable (3x)
	 * 3. Add the additive inverse of the constant Term to both sides of the equation (3x = -21)
	 * 4. Multiple both sides by the additive inverse of the coefficient of the variable term (.33333333)
	 */

	public void solveLinear(ArrayList<Term> sideWithVariable){//3x+4=0
		//3x+4+-4=-4;
	
		//Term term;
		int size = sideWithVariable.size();
		for(int j=0; j<size; j++){
			Term t = sideWithVariable.get(j);
			if (t.constant)
			{
				leftSide.add(t.getAddInverse());
				rightSide.add(t.getAddInverse());
				simplify(rightSide);
				simplify(leftSide);
				//leftSide.add(multiplyScalar1(sideWithVariable,1/t.getCoefficient()));
				//rightSide.add(multiplyScalar1(sideWithVariable,1/(t.getCoefficient())));
			}
		}
		
	}

	/**
	 * @param side
	 * @param scalar
	 * multiplies all Terms on the given side by the given scalar
	 * (Hint: use setCoefficient(double))
	 */

	public void multiplyScalar(ArrayList<Term> side, double scalar){
		for(int i=0; i<side.size(); i++)
		{
			Term afterMul= side.get(i);
			afterMul.setCoefficient(scalar*afterMul.coefficient);
		}
	}
	/*public Term multiplyScalar1(ArrayList<Term> side, double scalar){
		Term afterMul =;
		for(int i=0; i<side.size(); i++)
		{
		    afterMul= side.get(i);
		    afterMul.setCoefficient(scalar*afterMul.coefficient);
		}
		return afterMul;
	}*/
}

