type ProductMapper struct {
	Rows []Product `xml:"result>code>path>row"`
}

func (p *ProductMapper) SearchByName(name string) []Product {
	return p.Rows
}