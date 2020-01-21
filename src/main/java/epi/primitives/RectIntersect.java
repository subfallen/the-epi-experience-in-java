package epi.primitives;

import java.util.Optional;
import java.util.Comparator;

public class RectIntersect {
  public static class Rect {
    public final int xLow, yLow, xHigh, yHigh;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      } else if (!o.getClass().equals(RectIntersect.Rect.class)) {
        return false;
      } else {
        Rect that = (Rect)o;
        return this.xLow == that.xLow &&
                  this.yLow == that.yLow &&
                  this.xHigh == that.xHigh &&
                  this.yHigh == that.yHigh;
      }
    }

    public Rect(int xLow, int yLow, int xHigh, int yHigh) {
      this.xLow = xLow; 
      this.yLow = yLow; 
      this.xHigh = xHigh; 
      this.yHigh = yHigh;
    }

    public Segment xSeg() {
      return new Segment(xLow, xHigh - xLow);
    }

    public Segment ySeg() {
      return new Segment(yLow, yHigh - yLow);
    }

    @Override
    public String toString() {
      return String.format("RectIntersect{xLow=%d,yLow=%d,xHigh=%d,yHigh=%d}",
          xLow, yLow, xHigh, yHigh);
    }
  }

  public static class Segment {
    public final int coord, len;

    public int coord() {
      return coord;
    }

    public int end() {
      return coord + len;
    }

    public static Comparator<Segment> SEGMENT_CMP = 
      Comparator.comparingInt(Segment::coord);

    public Segment(int coord, int len) {
      this.coord = coord;
      this.len = len;
    }
  }

  public static Optional<Rect> interOf(Rect a, Rect b) {
    Optional<Segment> xInter = interOf(a.xSeg(), b.xSeg());
    Optional<Segment> yInter = interOf(a.ySeg(), b.ySeg());
    if (xInter.isEmpty() || yInter.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.of(
          new Rect(
            xInter.get().coord,
            yInter.get().coord,
            xInter.get().coord + xInter.get().len,
            yInter.get().coord + yInter.get().len)
      );
    }
  }

  private static Optional<Segment> interOf(Segment a, Segment b) {
    Segment l = (a.coord < b.coord) ? a : b;
    Segment r = (a.coord < b.coord) ? b : a;
    if (r.coord <= l.end()) {
      return Optional.of(
          new Segment(r.coord, Math.min(l.end(), r.end()) - r.coord));
    } else {
      return Optional.empty();
    }
  }
}
