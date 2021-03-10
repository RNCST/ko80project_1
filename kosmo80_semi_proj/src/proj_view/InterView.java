package proj_view;

import java.util.Vector;

import proj_back.MenuVO;

public interface InterView {

	abstract void initDisplay();
	abstract void refresh();
	abstract void setrow(Vector<MenuVO> mVOS);
}
