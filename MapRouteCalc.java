
/**
 * MapRouteCalc
 */
public class MapRouteCalc {

    public static void main(String[] args) {
        String header = "Calculation number of routes from (X,Y) to (N,M)";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < header.length(); i++) {
            sb.append("-");
        }
        System.out.println(header + "\n" + sb);

        int initX;
        int initY;
        int Nmax;
        int Mmax;

        if (args.length > 0 && args[0] != null) {
            initX = Integer.parseInt(args[0]);
            initY = Integer.parseInt(args[1]);
            Nmax = Integer.parseInt(args[2]);
            Mmax = Integer.parseInt(args[3]);
            System.out.printf("The following values are used:\n" +
                        "X = %d, Y = %d, N = %d, M = %d\n", initX, initY, Nmax, Mmax);
        } else {
            System.out.println("usage: java MapRouteCalc X Y N M\n-----");
            initX = 0;
            initY = 0;
            Nmax = 25;
            Mmax = 25;
            // System.out.printf("Используются значения по умолчанию:\n" +
                                // "X = %d, Y = %d, N = %d, M = %d\n", initX, initY, Nmax, Mmax);
            System.out.printf("Default values are used:\n" +
                                "X = %d, Y = %d, N = %d, M = %d\n", initX, initY, Nmax, Mmax);
        }
        int routes = routesOnMapCal(initX, initY, Nmax, Mmax);
        // System.out.printf("Количество маршрутов от (%d,%d) до (%d,%d) - %d", initX, initY, Nmax - 1, Mmax - 1, routes);
        System.out.printf("Number of routes from (%d,%d) to (%d,%d) -> %d\n", initX, initY, Nmax - 1, Mmax - 1, routes);
    }

    /**
     * Возвращает количество маршрутов от (Xinit, Yinit) до (N, M)
     * @param Xinit - начальное значение X
     * @param Yinit - начальное значение Y
     * @param N     - конечное значение, высота карты
     * @param M     - конечное значение, ширина карты
     * @return
     */
    public static int routesOnMapCal(int Xinit, int Yinit, int N, int M) {
        int[][] map = new int[N][M];

        for (int i = Xinit; i < N; i++) {
            for (int j = Yinit; j < M; j++) {
                if (i == Xinit || j == Yinit) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }
        return map[N - 1][M - 1];
    }

}