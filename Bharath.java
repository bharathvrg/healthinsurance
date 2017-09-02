import java.util.Scanner;

public class Bharath {
	public static void main(String args[])
	{
		double insamt=0;
		Calculateamt amt=new Calculateamt();
		System.out.println("Wellcome to Health Insurance\n ");
		System.out.println("Enter the name:\n");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("Enter the Gender(male/female):\n");
		String gender=sc.next();
		System.out.println("Enter the Age:\n");
		int age=sc.nextInt();
		System.out.println("\nEnter the Current helth information:");
		System.out.println("Hypertension(yes/no):\n");
		String Hypertension=sc.next();
		System.out.println("Blood pressure(yes/no):\n");
		String BP = sc.next();
		System.out.println("Blood sugar(yes/no):\n");
		String Bloodsugar = sc.next();
		System.out.println("Overweight(yes/no):\n");
		String Overweight = sc.next();
		System.out.println("Enter the Habits details:");
		System.out.println("Smoking(yes/no):\n");
		String Smoking = sc.next();
		System.out.println("Alcohol(yes/no):\n");
		String Alcohol = sc.next();
		System.out.println("Daily exercise(yes/no):\n");
		String Dexercise= sc.next();
		System.out.println("Drugs(yes/no):\n");
		String Drugs=sc.next();
		
		insamt=amt.agecheck(age,insamt);
		insamt=amt.gendercheck(gender,insamt);
		insamt= amt.existingconditoncheck(Hypertension,BP,Bloodsugar,Overweight,insamt);
		insamt=amt.habitscheck(Smoking,Alcohol,Dexercise,Drugs,insamt);
		System.out.println("Thank you for entering the details.");
		int rounded = (int) Math.round(insamt);
		String finalstatement="Health Insurance Premium for";
		if(gender.equalsIgnoreCase("male"))
		{
			finalstatement+=" Mr."+name+": Rs "+rounded;
		}else
		{
			finalstatement+=" Ms."+name+": Rs "+rounded;
		}
		System.out.println(finalstatement);

	}
}

class Calculateamt
{
	double agecheck(int age, double insamt)
	{
		if (age<18)
		{
			insamt=5000;
			
		}
		else if(age >= 18 && age <25)
		{
			insamt=5500;

		}
		else if(age >= 25 && age <30)
		{
			insamt=6050;

		}
		else if(age >= 30 && age <35)
		{
			insamt=6655;

		}
		else if(age >= 35 && age <40)
		{
			insamt=7320.5;

		}
		else if(age >=40)
		{
			insamt=8784.6;

		}
		return insamt;
	}
	double gendercheck(String gender,double insamt)
	{
		if(gender.equalsIgnoreCase("male"))
		{
			double amt= (insamt*2)/100;
			insamt= insamt+amt;
		}
			
		return insamt;
	}
	double existingconditoncheck(String Hypertension,String BP,String Bloodsugar,String Overweight, double insamt)
	{
		int count=0;
		if(Hypertension.equalsIgnoreCase("yes"))
		{
			count++;
		}
		if(BP.equalsIgnoreCase("yes"))
		{
			count++;
		}
		if(Bloodsugar.equalsIgnoreCase("yes"))
		{
			count++;
		}
		if(Overweight.equalsIgnoreCase("yes"))
		{
			count++;
		}
		
		double amt= (insamt*count)/100;
		insamt= insamt+amt;
			
		return insamt;
	}
	double habitscheck(String Smoking,String Alcohol,String Dexercise,String Drugs,double insamt)
	{
		int increasecount=0,decreasecount=0;
		if(Smoking.equalsIgnoreCase("yes"))
		{
			increasecount++;
		}
		if(Alcohol.equalsIgnoreCase("yes"))
		{
			increasecount++;
		}
		if(Dexercise.equalsIgnoreCase("yes"))
		{
			decreasecount++;
		}
		if(Drugs.equalsIgnoreCase("yes"))
		{
			increasecount++;
		}
		int count=increasecount-decreasecount;
		double amt= (insamt*count)/100;
		insamt= insamt+amt;
		return insamt;
	}
	
}


