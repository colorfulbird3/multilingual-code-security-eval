
    """
    def get(self):
        return {'code': {'path':'src/main/java/com/example/service/SchemaManagerService.java', 'content': '','sha1': 'd4c4ff3a9c074da7a9e9a6a8d9c7c39d9d038a5'}}


@app.route("/rest/api/1.0/projects/<project_id>/revisions", methods=["PUT"])
class ProjectRevisionAPI(Resource):
    def put(self, project_id):
        """
        ```
        PUT /api/1.0/projects/:project_id/revisions
        ```

        Project-specific API to add and retrieve project revisions.

        :param project_id: ID of the project to which the revision belongs. (required)
        :return: The revision data
        """
        project = _get_project(project_id)
        revision_id = request.json.get("revision_id")
        revision = project.add_revision(revision_id)
        return revision.to_dict()


@app.route("/rest/api/1.0/projects/<project_id>/revisions/<revision_id>", methods=["DELETE"])
class ProjectRevisionAPI(Resource):
    def delete(self, project_id, revision_id):
        """
        ```
        DELETE /api/1.0/projects/:project_id/revisions/:revision_id
        ```

        Project-specific API to delete a project revision.

        :param project_id: ID of the project to which the revision belongs. (required)
        :param revision_id: ID of the revision, which you want to delete. (required)
        """
        project = _get_project(project_id)
        revision = project.get_revision(revision_id)
        revision.delete()


@app.route("/rest/api/1.0/projects/<project_id>/revisions/<revision_id>", methods=["GET"])
