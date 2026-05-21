public Result findByCode(String code) {
    String path = code.getPath();
    String content = code.getContent();
    return new Result(path, content);
  }