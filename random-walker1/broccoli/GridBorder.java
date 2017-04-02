/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package broccoli;

/**
 *
 * @author Norway92
 */
public class GridBorder
  {
    
    public GridBorder()
    {
    }

    public int checkBorder(int position, int limit)
    {
        if (position > limit) {
            return limit;
        } else if (position < 0) {
            return 0;
        } else {
            return position;
        }
    }

  }
