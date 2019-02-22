package haven;

import java.awt.image.BufferedImage;
import java.util.function.Function;

public class ToggleButton extends IButton {
    private final BufferedImage upf, downf, hoverf, upt, downt, hovert;
    private boolean state = false;
    private Function<Boolean, Void> action;
    
    public ToggleButton(String basef, String upf, String downf, String hoverf,
			String baset, String upt, String downt, String hovert) {
	super(basef, upf, downf, hoverf);
	this.upf = up;
	this.downf = down;
	this.hoverf = hover;
	
	this.upt = Resource.loadimg(baset + upt);
	this.downt = Resource.loadimg(baset + downt);
	this.hovert = Resource.loadimg(baset + (hovert == null ? upt : hovert));
    }
    
    public void action(Function<Boolean, Void> action) {
	this.action = action;
    }
    
    @Override
    public void click() {
	state(!state);
	if(action != null) {
	    action.apply(state);
	} else {
	    super.click();
	}
    }
    
    public void state(boolean state) {
	this.state = state;
	up = state ? upt : upf;
	down = state ? downt : downf;
	hover = state ? hovert : hoverf;
	redraw();
    }
    
    public boolean state() {return state;}
}