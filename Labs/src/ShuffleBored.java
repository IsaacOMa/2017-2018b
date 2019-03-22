

public class ShuffleBored  
{  
  private final static String[] reserved =  
   { "abstract",     "assert",    "boolean",     "break",  
     "byte",         "case",      "catch",       "char",  
     "class",        "const",     "continue",    "default",  
     "do",           "double",    "else",        "extends",  
     "final",        "finally",   "float",       "for",  
     "goto",         "if",        "implements",  "import",  
     "instanceof",   "int",       "interface",   "long",  
     "native",       "new",       "package",     "private",  
     "protected",    "public",    "return",      "short",  
     "static",       "super",     "switch",      "synchronized",  
     "this",         "throw",     "throws",      "transient",  
     "try",          "void",      "volatile",    "while" };  
  
  public static void main(String[] args)  
  {  
    ShuffleTree<Integer> tree = new ShuffleTree<Integer>(30);  
    
  
    for (int index = 0; index < reserved.length; index += 1)  
    {  
      tree.put(reserved[index], index);  
    }
    
    tree.flush();

  
    System.out.println(tree.height());  
  
    for (int index = 0; index < reserved.length; index += 1)  
    {  
      System.out.format("%02d %s", tree.get(reserved[index]), reserved[index]);  
      System.out.println();  
    }  
  }  
}
