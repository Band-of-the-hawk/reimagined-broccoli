package broccoli;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Norway92
 */
public class LogInfo
  {
    private int currentStep;
    
    private final List<String> particlePos;
    
    public LogInfo()
    {
        this.particlePos = new ArrayList<>();
        this.currentStep = 1;
    }
    
    public void setCurrentStep(int step)
    {
        this.currentStep = step;
    }
  }
