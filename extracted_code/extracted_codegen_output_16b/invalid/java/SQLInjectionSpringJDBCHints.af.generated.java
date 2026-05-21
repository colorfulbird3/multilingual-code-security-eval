func (r *request) get(path string, isJson bool) *request {
	r.path = path

	if isJson {
		r.contentType = "application/json"
	}
	return r
}