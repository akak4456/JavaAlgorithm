import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
class Point {
	long x;
	long y;
	Point(long x, long y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	private static int N;
	private static Point[] points;
	private static Point root = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
	private static int ccw(Point p1, Point p2, Point p3) {
		long result = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
		if(result > 0) {
			return 1;
		} else if(result < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	private static long dist(Point p1, Point p2) {
		return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	}
	private static int convexHull() {
		for(int i=0;i<N;i++) {
			if(points[i].y < root.y) {
				root = points[i];
			} else if(points[i].y == root.y && points[i].x < root.x) {
				root = points[i];
			}
		}
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				int result = ccw(root, p1, p2);
				if(result > 0) {
					return -1;
				} else if(result < 0) {
					return 1;
				} else {
					long dist1 = dist(root, p1);
					long dist2 = dist(root, p2);
					if(dist1 > dist2) {
						return 1;
					}
				}
				return -1;
			}
		});

		Stack<Point> stack = new Stack<>();
		stack.add(root);
		for(int i=1;i<N;i++) {
			while(stack.size() > 1 && (ccw(stack.get(stack.size() -2), stack.get(stack.size() - 1), points[i]) <= 0)) {
				stack.pop();
			}
			stack.add(points[i]);
		}
		return stack.size();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		points = new Point[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x, y);
		}
		System.out.println(convexHull());
	}
}