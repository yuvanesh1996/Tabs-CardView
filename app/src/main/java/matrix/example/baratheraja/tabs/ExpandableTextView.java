package matrix.example.baratheraja.tabs;

/**
 * Created by N.Yuvanesh on 26-11-2015.
 */

        import android.content.Context;
        import android.graphics.Color;
        import android.text.Spannable;
        import android.text.SpannableStringBuilder;
        import android.text.Spanned;
        import android.text.style.ForegroundColorSpan;
        import android.text.style.StyleSpan;
        import android.util.AttributeSet;
        import android.view.View;
        import android.widget.TextView;

public class ExpandableTextView extends TextView {
    private static final int DEFAULT_TRIM_LENGTH = 200;
    private static final String ELLIPSIS ="..........."+"\n\n"+"SHOW MORE > >";

    private CharSequence originalText;
    private CharSequence trimmedText;
    private BufferType bufferType;
    private boolean trim = true;
    private int trimLength;

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

       trimLength = DEFAULT_TRIM_LENGTH;
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                trim = !trim;
                setText();
                requestFocusFromTouch();
            }
        });
    }

    private void setText() {
       super.setText(getDisplayableText(), bufferType);

    }

    private CharSequence getDisplayableText() {
        boolean isRequired= originalText.length() > trimLength;
        SpannableStringBuilder more= new SpannableStringBuilder("\n\n SHOW MORE > >  ");
        SpannableStringBuilder less= new SpannableStringBuilder("\n\n < < SHOW LESS  ");

        CharSequence result= trim ? (trimmedText) :(originalText);



        SpannableStringBuilder sp= new SpannableStringBuilder(result);

        final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.rgb(158, 158, 158));
        more.setSpan(fcs,0,more.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        less.setSpan(fcs,0,less.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        if(isRequired && trim )
            sp.append(more);
        else if(isRequired && !trim)
            sp.append(less);


        return sp;


    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        originalText = text;
        trimmedText = getTrimmedText(text);
        bufferType = type;
        setText();
    }

    private CharSequence getTrimmedText(CharSequence text) {
        if (originalText != null && originalText.length() > trimLength) {
            return new SpannableStringBuilder(originalText, 0, trimLength + 1);

        } else {
            return originalText;
        }
    }

    public CharSequence getOriginalText() {

         return originalText;
    }

}