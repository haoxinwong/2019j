ùó
    private int size;

    public SplitFile(String srcPath,String destDir) {
        this(srcPath,destDir,1024);
    }
    
    public SplitFile(String srcPath,String destDir,int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blo