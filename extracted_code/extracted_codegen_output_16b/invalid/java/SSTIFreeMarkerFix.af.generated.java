from flask import Blueprint, request, render_template

from app import db, app
from app.models import User, Project, Report, ProjectReport, ReportParamItem, UserProject
import json

user_profile = Blueprint('user_profile', __name__)

@user_profile.route('/user_profile', methods=['GET', 'POST'])
def user_profile_page():
    login_required = True
    if app.auth_service.is_logged_in():
        login_required = False
    
    if request.method == 'GET':
        return render_template('user_profile.html', login_required=login_required)
    
    if login_required:
        return render_template('user_profile.html', login_required=login_required, error="Please log in!")
    
    # If we don't have a user associated with the current session, disallow the call
    if not app.auth_service.is_logged_in():
        return render_template('user_profile.html', login_required=login_required, error="Please log in!")
    
    # Pull username and template content from the POST request parameters
    username = request.form['username']
    template = request.form['template']
    
    # Handle the POST request
    if request.method == "POST":
        template_content = template
        
        # If a POST request to this method was made, render the user profile page
        return render_template('user_profile.html', login_required=login_required, username=username, template_content=template_content)