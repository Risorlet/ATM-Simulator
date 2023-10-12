package com.risorlet.ATM_Simulator;

// This class is for the document model of textFields to restrict input length

import javax.swing.text.*;

public class LengthRestrictedDocument extends PlainDocument{

    private final int limit;

    public LengthRestrictedDocument(int limit) {
        this.limit = limit;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

        if (str == null) {
            return;
        }

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offs, str, a);
        }
    }
    
}
