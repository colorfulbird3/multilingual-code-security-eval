
*/
func (this *XMLParserV2) ParseXML(data []byte) (*Result, error) {
    dec := xml.NewDecoder(bytes.NewReader(data))
    dec.CharsetReader = charset.NewReaderLabel
    result := &Result{}
    err := dec.Decode(result)
    if err!= nil {
        return nil, err
    }
    return result, nil
}
