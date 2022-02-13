public class Triangle {
    public static void main(String[] args) {

        Parties (3, 4, 5);

    }

    public static double Parties(int a, int b, int c) {

        double p = ((double)(a+b+c))/2;

        if (p <= a || p <= b || p <= c || a*b*c==0) {

            return -1;
        }
        double S = Math.sqrt(p*(p - a)*(p - b)*(p - c));

        if (a == b && b == c) {
            System.out.println(" Площадь равна " + S + " Это равностороний треугольник");
        } else if (a==b || a==c || b==c) {
            System.out.println(" Площадь равна " + S + " Это равнобедренный треугольник");
        } else if (S == 0.5*a*b || S == 0.5*a*c || S == 0.5*c*b){
            System.out.println(" Площадь равна " + S + " Это прямоугольный треугольник");
        } else {
            System.out.println(" Площадь равна " + S + " Это разносторонний треугольник");
        }
        return S;
    }

}
