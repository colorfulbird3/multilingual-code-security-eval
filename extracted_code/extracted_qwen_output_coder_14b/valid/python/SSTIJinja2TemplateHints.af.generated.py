import jinja2

def render_user_profile_bio(bio_content: str) -> str:
    # Define the template for the user profile bio section
    template = jinja2.Template("""
    <div class="user-profile-bio">
        <p>{{ bio }}</p>
    </div>
    """)
    
    # Render the template with the provided bio content
    rendered_html = template.render(bio=bio_content)
    
    return rendered_html