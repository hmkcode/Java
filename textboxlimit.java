  tf1.addKeyListener(new KeyAdapter() {  
         public void keyTyped(KeyEvent e) {  
           char c = e.getKeyChar();  
           if (!(Character.isDigit(c) ||  
              (c == KeyEvent.VK_BACK_SPACE) ||  
              (c == KeyEvent.VK_DELETE))) {  
                e.consume();  
              }  
         }  
       });  
