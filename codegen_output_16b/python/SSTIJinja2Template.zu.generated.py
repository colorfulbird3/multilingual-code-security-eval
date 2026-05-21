-`src/profile_renderer/profile_renderer.py` ngefomethi elandelayo:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Okuhlelo

Kiphasi:
```
    from profile_renderer import ProfileRenderer
    renderer = ProfileRenderer('path/to/profile.json')
    renderer.render()
```

## Uwaholiswa
```
    import profile_renderer
    profile_renderer.ProfileRenderer.render('/tmp/profile.html', {'profile': {
        'bio_content': 'Profile bio content here.'
    }})
```
