package interview_cake;

/**
 * Created by Anna on 7/4/17.
 */
public class rangeOverlap {

    public static class Rectangle {

        // "zero" rectangle
        public static final Rectangle NO_RECTANGLE = new Rectangle();

        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;

        // dimensions
        private int width;
        private int height;

        public Rectangle() {}

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    private static class RangeOverlap1 {

        public static final RangeOverlap1 NO_OVERLAP = new RangeOverlap1();

        private int startPoint;
        private int length;

        public RangeOverlap1() {}

        public RangeOverlap1(int startPoint, int length) {
            this.startPoint = startPoint;
            this.length = length;
        }

        public int getStartPoint() {
            return startPoint;
        }

        public int getLength() {
            return length;
        }
    }

    private static RangeOverlap1 findRangeOverlap(int point1, int length1, int point2, int length2) {

        // find the highest start point and lowest end point.
        // the highest ("rightmost" or "upmost") start point is
        // the start point of the overlap.
        // the lowest end point is the end point of the overlap.
        int highestStartPoint = Math.max(point1, point2);
        int lowestEndPoint = Math.min(point1 + length1, point2 + length2);

        // return null overlap if there is no overlap
        if (highestStartPoint >= lowestEndPoint) {
            return RangeOverlap1.NO_OVERLAP;
        }

        // compute the overlap length
        int overlapLength = lowestEndPoint - highestStartPoint;

        return new RangeOverlap1(highestStartPoint, overlapLength);
    }

    public static Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {

        // get the x and y overlap points and lengths
        RangeOverlap1 xOverlap = findRangeOverlap(rect1.leftX, rect1.width, rect2.leftX, rect2.width);
        RangeOverlap1 yOverlap = findRangeOverlap(rect1.bottomY, rect1.height, rect2.bottomY, rect2.height);

        // return "zero" rectangle if there is no overlap
        if (xOverlap.getLength() == 0 || yOverlap.getLength() == 0) {
            return Rectangle.NO_RECTANGLE;
        }

        return new Rectangle(
                xOverlap.startPoint,
                yOverlap.startPoint,
                xOverlap.length,
                yOverlap.length
        );
    }
}
