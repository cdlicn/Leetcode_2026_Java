public class Main_2069 {
    class Robot {
        private int w, h, s;

        public Robot(int width, int height) {
            w = width;
            h = height;
            s = 0;
        }

        public void step(int num) {
            s = (s + num - 1) % ((w + h - 2) * 2) + 1;
        }

        public int[] getPos() {
            Object[] t = getState();
            return new int[]{(int) t[0], (int) t[1]};
        }

        public String getDir() {
            Object[] t = getState();
            return (String) t[2];
        }

        private Object[] getState() {
            if (s < w) {
                return new Object[]{s, 0, "East"};
            } else if (s < w + h - 1) {
                return new Object[]{w - 1, s - w + 1, "North"};
            } else if (s < w * 2 + h - 2) {
                return new Object[]{w * 2 + h - s - 3, h - 1, "West"};
            } else {
                return new Object[]{0, (w + h) * 2 - s - 4, "South"};
            }
        }
    }
}
