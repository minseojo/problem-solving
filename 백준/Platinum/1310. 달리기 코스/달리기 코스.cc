#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

struct Point {
    int x, y;
    
    Point(int x = 0, int y = 0) : x(x), y(y) {}
};

// CCW (Counter Clockwise) 연산
long long ccw(Point p1, Point p2, Point p3) {
    return (long long)(p2.x - p1.x) * (p3.y - p2.y) - (long long)(p3.x - p2.x) * (p2.y - p1.y);
}

// 두 점 사이의 거리의 제곱을 계산
long long getPowDistance(Point p1, Point p2) {
    return (long long)(p2.x - p1.x) * (p2.x - p1.x) + (long long)(p2.y - p1.y) * (p2.y - p1.y);
}

// 컨벡스 헐 (Convex Hull) 계산
vector<Point> initConvexHull(vector<Point>& points) {
    vector<Point> lower, upper, convexHull;

    // x 좌표 기준으로 정렬, 동일하면 y 기준 정렬
    sort(points.begin(), points.end(), [](const Point& p1, const Point& p2) {
        return (p1.x == p2.x) ? (p1.y < p2.y) : (p1.x < p2.x);
    });

    for (size_t i = 0; i < points.size(); i++) {
        while (lower.size() >= 2 && ccw(lower[lower.size() - 2], lower[lower.size() - 1], points[i]) >= 0) {
            lower.pop_back();
        }
        lower.push_back(points[i]);
    }

    for (size_t i = points.size(); i-- > 0; ) {
        while (upper.size() >= 2 && ccw(upper[upper.size() - 2], upper[upper.size() - 1], points[i]) >= 0) {
            upper.pop_back();
        }
        upper.push_back(points[i]);
    }

    lower.pop_back();
    upper.pop_back();

    convexHull.insert(convexHull.end(), lower.begin(), lower.end());
    convexHull.insert(convexHull.end(), upper.begin(), upper.end());

    return convexHull;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<Point> points(n);

    for (int i = 0; i < n; i++) {
        cin >> points[i].x >> points[i].y;
    }

    vector<Point> convexHull = initConvexHull(points);

    int j = 1;
    long long result = 0;
    Point standardPoint(0, 0);

    for (size_t i = 0; i < convexHull.size(); i++) {
        size_t iNext = (i + 1) % convexHull.size();
        while (true) {
            size_t jNext = (j + 1) % convexHull.size();
            Point iVector(convexHull[iNext].x - convexHull[i].x, convexHull[iNext].y - convexHull[i].y);
            Point jVector(convexHull[jNext].x - convexHull[j].x, convexHull[jNext].y - convexHull[j].y);

            if (ccw(standardPoint, iVector, jVector) < 0) {
                j = jNext;
            } else {
                break;
            }
        }
        result = max(result, getPowDistance(convexHull[i], convexHull[j]));
    }

    cout << result << "\n";
    return 0;
}
