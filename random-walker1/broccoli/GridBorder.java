package broccoli;

/**
 *
 * @author Norway92
 */
public class GridBorder
  {
    private final LogInfo logI;
    
    public GridBorder(LogInfo logI)
    {
        this.logI = logI;
    }

    public int checkBorder(int position, int limit)
    {
        if (position > limit) {
            return limit;
        } else if (position < -limit) {
            return -limit;
        } else {
            return position;
        }
    }

  }
