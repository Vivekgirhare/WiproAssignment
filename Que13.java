//13. Create a class called Worker. Write classes DailyWorker and SalariedWorker that inherit from
//Worker. Every worker has a name and a salaryrate. Write method Pay (int hours) to compute 
//the week pay of every worker.  A Daily worker is paid on the basis of the number of days 
//she/he works. The salaried worker gets paid the wage for 40 hours a week no matter what the
//actual hours are.  Test this program to calculate the pay of workers. 

package javaAssignment;

class que13_Worker {
    String name;
    double salaryRate;

    que13_Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    double pay(int hours) {
        return 0;
    }
}

class que13_DailyWorker extends que13_Worker {
    que13_DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    double pay(int days) {
        return salaryRate * days;
    }
}

class que13_SalariedWorker extends que13_Worker {
    que13_SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    double pay(int hours) {
        return salaryRate * 40;
    }
}

public class Que13 {
    public static void main(String[] args) {
        que13_DailyWorker dw = new que13_DailyWorker("Rahul", 500);
        que13_SalariedWorker sw = new que13_SalariedWorker("Sneha", 600);

        System.out.println("DailyWorker Weekly Pay: ₹" + dw.pay(6));
        System.out.println("SalariedWorker Weekly Pay: ₹" + sw.pay(50));
    }
}
