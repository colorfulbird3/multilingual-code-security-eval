from jinja2 import Template

def render_user_profile_bio(bio_content: str) -> str:
    # Define the template for the user profile bio
    template = Template("""
    <div class="user-profile-bio">
        <p>{{ bio_content }}</p>
    </div>
    """)
    
    # Render the template with the provided bio content
    rendered_html = template.render(bio_content=bio_content)
    
    return rendered_html