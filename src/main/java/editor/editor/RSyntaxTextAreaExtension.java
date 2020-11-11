package editor.editor;

import java.awt.FontMetrics;

import javax.swing.text.Element;
import javax.swing.text.Segment;
import javax.swing.text.TabExpander;
import javax.swing.text.Utilities;
import javax.swing.text.View;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextAreaUI;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.WrappedSyntaxView;
import org.fife.ui.rtextarea.RTextArea;
import org.fife.ui.rtextarea.RTextAreaUI;

public class RSyntaxTextAreaExtension extends RSyntaxTextArea {

	public RSyntaxTextAreaExtension() {
		super(50, 50);
	}

	protected RTextAreaUI createRTextAreaUI() {
		return new RSyntaxTextAreaUI(this) {
			public View create(Element elem) {
				RTextArea c = getRTextArea();
				if (c instanceof RSyntaxTextArea) {
					RSyntaxTextArea area = (RSyntaxTextArea) c;
					if (area.getLineWrap()) {
						return new WrappedSyntaxView(elem) {
							protected int calculateBreakPosition(int p0, Token tokenList, float x0) {
								int p = p0;
								RSyntaxTextArea textArea = (RSyntaxTextArea) getContainer();
								FontMetrics metrics = textArea.getFontMetrics(textArea.getFont());
								float currentWidth = getWidth();
								if (currentWidth == Integer.MAX_VALUE) {
									currentWidth = getPreferredSpan(X_AXIS);
								}
								currentWidth = Math.max(currentWidth, 20);
								Token t = tokenList;
								while (t != null && t.isPaintable()) {
									float tokenWidth = t.getWidth(textArea, this, x0);
									if (tokenWidth > currentWidth) {
//											return t.getOffsetBeforeX(textArea, this, 0, currentWidth);
										return getBreakLocation(t, metrics, (int) x0, (int) currentWidth, this);
									}
									currentWidth -= tokenWidth;
									x0 += tokenWidth;
									p += t.length();
									t = t.getNextToken();
								}
								return p + 1;
							}

							private int getBreakLocation(Token t, FontMetrics fm, int x0, int x, TabExpander e) {
								Segment s = new Segment();
								s.array = t.getTextArray();
								s.offset = t.getTextOffset();
								s.count = t.length();
								return t.getOffset() + Utilities.getBreakLocation(s, fm, x0, x + x0, e, t.getOffset());
							}
						};
					}
				}
				return super.create(elem);
			}
		};
	}
}