package Unit3.GradeCheck;


public class Grade
{

    private double numGrade;

    public Grade()
    {
    }

    public Grade(double grade)
    {
        this.numGrade = grade;
    }

    public void setGrade(double grade)
    {

    }

    public String getLetterGrade( )
    {
        String letGrade="";
        if (numGrade >= 89.5){
            letGrade = "A";
        } else if (numGrade >= 79.5){
            letGrade = "B";
        } else if (numGrade >= 69.5){
            letGrade = "C";
        } else if (numGrade >= 59.5){
            letGrade = "D";
        } else {
            letGrade = "F";
        }

        return letGrade;
    }

    public String toString()
    {
        return String.format("%.2f",numGrade) + " is a " + getLetterGrade();
    }
}