// Last updated: 4/15/2026, 3:41:50 PM
class Robot {
    private int width;
    private int height;
    private int pos;
    private int perimeter;
    private boolean moved;
    private String[] dirLabel = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height - 4) + 4;
        this.pos = 0;
        this.moved = false;
    }

    public void step(int num) {
        moved = true;
        pos = (pos + num) % perimeter;
    }

    public int[] getPos() {
        if (pos < width) {
            return new int[]{pos, 0};
        } else if (pos < width + height - 1) {
            return new int[]{width - 1, pos - (width - 1)};
        } else if (pos < 2 * width + height - 2) {
            return new int[]{(width - 1) - (pos - (width + height - 2)), height - 1};
        } else {
            return new int[]{0, (height - 1) - (pos - (2 * width + height - 3))};
        }
    }

    public String getDir() {
        if (!moved) return "East";
        
        if (pos > 0 && pos < width) {
            return dirLabel[0];
        } else if (pos >= width && pos < width + height - 1) {
            return dirLabel[1];
        } else if (pos >= width + height - 1 && pos < 2 * width + height - 2) {
            return dirLabel[2];
        } else if (pos >= 2 * width + height - 2 || pos == 0) {
            return dirLabel[3];
        }
        return "East";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */