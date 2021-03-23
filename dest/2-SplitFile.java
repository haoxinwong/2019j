�块
    private int size;

    public SplitFile(String srcPath,String destDir) {
        this(srcPath,destDir,1024);
    }
    
    public SplitFile(String srcPath,String destDir,int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<String>();
        //初始化
        init();
    }
    
    //初始化
    private void init(){
        //总长度
        long len = this.src.length();
        //块数：多少块
        this.size = (int)Math.ceil(len*1.0/blockSize);
        
        //路径
        for(int i =0;i<size;i++){
            this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
        }
    }
    
    /**
     * 分割
     * 1.计算每一块的起始位置及大小
     * 2.分割
     */
    public void split() throws IOException{
        //总长度
        long len = src.length();
        //起始位置和实际大小
        int begin